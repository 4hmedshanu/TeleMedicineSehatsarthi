// Initialize the map
const map = L.map('map').setView([40.7128, -74.0060], 12); // Default to New York

// Add tile layer
L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
}).addTo(map);

// Sample hospital data
const hospitals = [
    {
        id: 1,
        name: "City General Hospital",
        lat: 40.7128,
        lng: -74.0120,
        distance: "1.2 miles",
        specialists: {
            cardiologist: { available: true, waitTime: "15 min" },
            neurologist: { available: true, waitTime: "30 min" },
            orthopedic: { available: false, waitTime: "N/A" },
            pediatrician: { available: true, waitTime: "10 min" },
            oncologist: { available: true, waitTime: "45 min" },
            dermatologist: { available: false, waitTime: "N/A" }
        }
    },
    {
        id: 2,
        name: "Metropolitan Medical Center",
        lat: 40.7282,
        lng: -73.9942,
        distance: "2.5 miles",
        specialists: {
            cardiologist: { available: true, waitTime: "20 min" },
            neurologist: { available: false, waitTime: "N/A" },
            orthopedic: { available: true, waitTime: "25 min" },
            pediatrician: { available: true, waitTime: "15 min" },
            oncologist: { available: false, waitTime: "N/A" },
            dermatologist: { available: true, waitTime: "40 min" }
        }
    },
    {
        id: 3,
        name: "Westside Community Hospital",
        lat: 40.7589,
        lng: -73.9851,
        distance: "3.1 miles",
        specialists: {
            cardiologist: { available: false, waitTime: "N/A" },
            neurologist: { available: true, waitTime: "50 min" },
            orthopedic: { available: true, waitTime: "35 min" },
            pediatrician: { available: true, waitTime: "20 min" },
            oncologist: { available: true, waitTime: "60 min" },
            dermatologist: { available: true, waitTime: "30 min" }
        }
    },
    {
        id: 4,
        name: "Northside Medical Center",
        lat: 40.7913,
        lng: -73.9732,
        distance: "4.7 miles",
        specialists: {
            cardiologist: { available: true, waitTime: "40 min" },
            neurologist: { available: true, waitTime: "25 min" },
            orthopedic: { available: false, waitTime: "N/A" },
            pediatrician: { available: false, waitTime: "N/A" },
            oncologist: { available: true, waitTime: "55 min" },
            dermatologist: { available: true, waitTime: "35 min" }
        }
    }
];

// Variables to store markers and route
let hospitalMarkers = [];
let userLocationMarker = null;
let routeLayer = null;

// Form submission handler
document.getElementById('searchForm').addEventListener('submit', function(e) {
    e.preventDefault();
    
    const specialist = document.getElementById('specialist').value;
    const location = document.getElementById('location').value;
    const radius = document.getElementById('radius').value;
    
    if (!specialist || !location) {
        alert('Please select a specialist and enter your location');
        return;
    }
    
    // In a real app, you would geocode the location and filter hospitals by distance
    // For this demo, we'll just filter by specialist availability
    displayHospitals(specialist);
    
    // Set user location marker (using a fixed location for demo)
    setUserLocation(40.7128, -74.0060);
});

// Display hospitals based on specialist availability
function displayHospitals(specialist) {
    const container = document.getElementById('hospitalsContainer');
    container.innerHTML = '';
    
    const availableHospitals = hospitals.filter(hospital => 
        hospital.specialists[specialist] && hospital.specialists[specialist].available
    );
    
    if (availableHospitals.length === 0) {
        container.innerHTML = '<div class="no-results">No hospitals found with this specialist in your area</div>';
        return;
    }
    
    availableHospitals.forEach(hospital => {
        const card = document.createElement('div');
        card.className = 'hospital-card';
        card.dataset.id = hospital.id;
        
        const availability = hospital.specialists[specialist];
        const availabilityClass = availability.waitTime === "N/A" ? "unavailable" : 
                                 parseInt(availability.waitTime) < 30 ? "available" : "limited";
        
        card.innerHTML = `
            <div class="hospital-name">${hospital.name}</div>
            <div class="hospital-distance">${hospital.distance} away</div>
            <div class="specialist-info">
                <span class="availability ${availabilityClass}">
                    ${availability.waitTime === "N/A" ? 'Not Available' : `Wait: ${availability.waitTime}`}
                </span>
            </div>
        `;
        
        card.addEventListener('click', () => selectHospital(hospital));
        container.appendChild(card);
    });
    
    // Clear previous markers
    clearHospitalMarkers();
    
    // Add markers for available hospitals
    availableHospitals.forEach(hospital => {
        const marker = L.marker([hospital.lat, hospital.lng])
            .addTo(map)
            .bindPopup(`<b>${hospital.name}</b><br>${hospital.distance} away`);
        
        hospitalMarkers.push(marker);
    });
    
    // Fit map to show all hospital markers
    if (availableHospitals.length > 0) {
        const group = new L.featureGroup(hospitalMarkers);
        map.fitBounds(group.getBounds().pad(0.1));
    }
}

// Set user location on the map
function setUserLocation(lat, lng) {
    if (userLocationMarker) {
        map.removeLayer(userLocationMarker);
    }
    
    userLocationMarker = L.marker([lat, lng], {
        icon: L.divIcon({
            className: 'user-location-marker',
            html: '<div style="background-color: #1a73e8; width: 20px; height: 20px; border-radius: 50%; border: 3px solid white; box-shadow: 0 2px 5px rgba(0,0,0,0.3);"></div>',
            iconSize: [20, 20],
            iconAnchor: [10, 10]
        })
    }).addTo(map).bindPopup('Your Location').openPopup();
}

// Select a hospital and show route
function selectHospital(hospital) {
    // Update UI
    document.querySelectorAll('.hospital-card').forEach(card => {
        card.classList.remove('selected');
    });
    document.querySelector(`.hospital-card[data-id="${hospital.id}"]`).classList.add('selected');
    
    // Show route info
    document.getElementById('routeInfo').style.display = 'block';
    document.getElementById('routeDistance').textContent = hospital.distance;
    document.getElementById('routeTime').textContent = calculateRouteTime(hospital.distance);
    
    // Calculate and display route (simulated for demo)
    displayRoute(hospital);
}

// Display route on the map
function displayRoute(hospital) {
    // Remove previous route
    if (routeLayer) {
        map.removeLayer(routeLayer);
    }
    
    // In a real app, you would use a routing service like OSRM or Mapbox
    // For this demo, we'll create a simple straight line
    const userLatLng = userLocationMarker.getLatLng();
    const hospitalLatLng = L.latLng(hospital.lat, hospital.lng);
    
    // Create a polyline between user and hospital
    routeLayer = L.polyline([userLatLng, hospitalLatLng], {
        color: '#1a73e8',
        weight: 5,
        opacity: 0.7,
        dashArray: '10, 10'
    }).addTo(map);
    
    // Fit map to show both points and the route
    const bounds = L.latLngBounds([userLatLng, hospitalLatLng]);
    map.fitBounds(bounds, { padding: [20, 20] });
}

// Calculate route time based on distance (simplified)
function calculateRouteTime(distanceStr) {
    const distance = parseFloat(distanceStr);
    // Assuming average speed of 30 mph in city traffic
    const timeInMinutes = Math.round((distance / 30) * 60);
    return `${timeInMinutes} min`;
}

// Clear hospital markers from the map
function clearHospitalMarkers() {
    hospitalMarkers.forEach(marker => {
        map.removeLayer(marker);
    });
    hospitalMarkers = [];
}

// Initialize with some sample data
window.addEventListener('load', function() {
    // Set a default specialist and location for demo purposes
    document.getElementById('specialist').value = 'cardiologist';
    document.getElementById('location').value = 'New York, NY';
    
    // Display hospitals with the default specialist
    displayHospitals('cardiologist');
    setUserLocation(40.7128, -74.0060);
});