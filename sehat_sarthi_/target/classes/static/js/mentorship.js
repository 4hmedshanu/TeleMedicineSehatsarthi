// Mock API endpoint - Replace with your actual API endpoint
 const API_BASE_URL = 'https://api.example.com/doctors'; // Replace with your API URL
 
 // Mock hospital data
 const hospitals = [
   {
     id: 1,
     name: "Sehat Sarthi Main Hospital",
     address: "Karki Farm, Tanakpur, Champawat, Uttarakhand 262309",
     distance: "2.5 km",
     phone: "9368449862"
   },
   {
     id: 2,
     name: "Sehat Sarthi City Clinic",
     address: "City Center, Mall Road, Tanakpur, Uttarakhand",
     distance: "1.2 km",
     phone: "9876543210"
   },
   {
     id: 3,
     name: "Sehat Sarthi North Branch",
     address: "North Extension, Highway Road, Tanakpur, Uttarakhand",
     distance: "4.7 km",
     phone: "8765432109"
   },
   {
     id: 4,
     name: "Sehat Sarthi South Clinic",
     address: "South Point, Market Area, Tanakpur, Uttarakhand",
     distance: "3.1 km",
     phone: "7654321098"
   }
 ];

 // Handle consultation type change
 function handleConsultationTypeChange(type) {
   const doctorSelection = document.getElementById('doctorSelection');
   const hospitalSelection = document.getElementById('hospitalSelection');
   
   // Reset selections
   document.getElementById('selectedDoctor').value = '';
   document.getElementById('selectedHospital').value = '';
   
   if (type === 'offline') {
     // Show hospital selection for clinic visits
     doctorSelection.style.display = 'none';
     hospitalSelection.style.display = 'block';
     loadHospitals();
   } else {
     // Show doctor selection for online consultations
     hospitalSelection.style.display = 'none';
     if (document.getElementById('specialty').value) {
       doctorSelection.style.display = 'block';
     }
   }
 }

 // Load hospitals
 function loadHospitals() {
   const hospitalList = document.getElementById('hospitalList');
   hospitalList.innerHTML = '';
   
   hospitals.forEach(hospital => {
     const hospitalCard = document.createElement('div');
     hospitalCard.className = 'hospital-card';
     hospitalCard.setAttribute('data-hospital-id', hospital.id);
     hospitalCard.onclick = function() { selectHospital(this, hospital.id); };
     
     hospitalCard.innerHTML = `
       <div class="hospital-info">
         <div class="hospital-icon">
           <i class="bi bi-hospital"></i>
         </div>
         <div class="hospital-details">
           <h5>${hospital.name}</h5>
           <p>${hospital.address}</p>
           <div class="hospital-distance">
             <i class="bi bi-geo-alt"></i>
             <span>${hospital.distance} away • ${hospital.phone}</span>
           </div>
         </div>
       </div>
     `;
     
     hospitalList.appendChild(hospitalCard);
   });
 }

 // Select a hospital
 function selectHospital(hospitalCard, hospitalId) {
   // Remove selected class from all hospital cards
   const allHospitalCards = document.querySelectorAll('.hospital-card');
   allHospitalCards.forEach(card => {
     card.classList.remove('selected');
   });
   
   // Add selected class to clicked hospital card
   hospitalCard.classList.add('selected');
   
   // Set the selected hospital value
   document.getElementById('selectedHospital').value = hospitalId;
 }

 // Fetch doctors by specialty from API
 async function fetchDoctorsBySpecialty(specialty) {
   const doctorSelection = document.getElementById('doctorSelection');
   const doctorList = document.getElementById('doctorList');
   const loadingSpinner = document.getElementById('loadingSpinner');
   const errorMessage = document.getElementById('errorMessage');
   const consultationType = document.getElementById('consultationType').value;
   
   // Clear previous doctor list and reset selection
   doctorList.innerHTML = '';
   document.getElementById('selectedDoctor').value = '';
   errorMessage.style.display = 'none';
   
   if (!specialty) {
     doctorSelection.style.display = 'none';
     return;
   }
   
   // Only show doctor selection for online consultations
   if (consultationType !== 'offline') {
     // Show doctor selection section and loading spinner
     doctorSelection.style.display = 'block';
     loadingSpinner.style.display = 'block';
     
     try {
       // In a real implementation, you would use fetch() to call your API
       // const response = await fetch(`${API_BASE_URL}?specialty=${specialty}`);
       // const doctors = await response.json();
       
       // For demonstration, using mock data with a delay to simulate API call
       const doctors = await mockFetchDoctors(specialty);
       
       // Hide loading spinner
       loadingSpinner.style.display = 'none';
       
       if (doctors && doctors.length > 0) {
         // Add doctors to the list
         doctors.forEach(doctor => {
           const doctorCard = document.createElement('div');
           doctorCard.className = 'doctor-card';
           doctorCard.setAttribute('data-doctor-id', doctor.id);
           doctorCard.onclick = function() { selectDoctor(this, doctor.id); };
           
           // Generate star rating HTML
           const stars = '★'.repeat(Math.floor(doctor.rating)) + '☆'.repeat(5 - Math.floor(doctor.rating));
           
           doctorCard.innerHTML = `
             <div class="doctor-info">
               <img src="${doctor.image}" alt="${doctor.name}" class="doctor-img">
               <div class="doctor-details">
                 <h5>${doctor.name}</h5>
                 <p>${specialty.charAt(0).toUpperCase() + specialty.slice(1)} • ${doctor.experience}</p>
                 <div class="doctor-rating">
                   <span class="rating-stars">${stars}</span>
                   <span class="rating-value">${doctor.rating}</span>
                 </div>
               </div>
             </div>
           `;
           
           doctorList.appendChild(doctorCard);
         });
       } else {
         doctorList.innerHTML = '<p class="text-center">No doctors available for this specialty.</p>';
       }
     } catch (error) {
       console.error('Error fetching doctors:', error);
       loadingSpinner.style.display = 'none';
       errorMessage.style.display = 'block';
       document.getElementById('errorText').textContent = 'Failed to load doctors. Please try again.';
     }
   }
 }

 // Mock API function - Replace with actual API call
 async function mockFetchDoctors(specialty) {
   // Simulate API delay
   await new Promise(resolve => setTimeout(resolve, 1000));
   
   // Mock doctor data
   const mockDoctors = {
     cardiology: [
       { id: 1, name: "Dr. Rakesh Kumar", experience: "15 years", rating: 4.8, image: "https://images.unsplash.com/photo-1612349317150-e413f6a5b16d?w=100&h=100&fit=crop&crop=face" },
       { id: 2, name: "Dr. Anjali Sharma", experience: "12 years", rating: 4.7, image: "https://images.unsplash.com/photo-1559839734-2b71ea197ec2?w=100&h=100&fit=crop&crop=face" },
       { id: 3, name: "Dr. Vikram Singh", experience: "18 years", rating: 4.9, image: "https://images.unsplash.com/photo-1582750433449-648ed127bb54?w=100&h=100&fit=crop&crop=face" }
     ],
     neurology: [
       { id: 4, name: "Dr. Priya Mehta", experience: "14 years", rating: 4.6, image: "https://images.unsplash.com/photo-1594824947933-d0501ba2fe65?w=100&h=100&fit=crop&crop=face" },
       { id: 5, name: "Dr. Rajesh Verma", experience: "16 years", rating: 4.8, image: "https://images.unsplash.com/photo-1622253692010-333f2da6031d?w=100&h=100&fit=crop&crop=face" }
     ],
     pediatrics: [
       { id: 6, name: "Dr. Sunita Reddy", experience: "11 years", rating: 4.9, image: "https://images.unsplash.com/photo-1551601651-2a8555f1a136?w=100&h=100&fit=crop&crop=face" },
       { id: 7, name: "Dr. Amit Joshi", experience: "13 years", rating: 4.7, image: "https://images.unsplash.com/photo-1612349317150-e413f6a5b16d?w=100&h=100&fit=crop&crop=face" }
     ],
     dermatology: [
       { id: 8, name: "Dr. Neha Gupta", experience: "10 years", rating: 4.5, image: "https://images.unsplash.com/photo-1559839734-2b71ea197ec2?w=100&h=100&fit=crop&crop=face" },
       { id: 9, name: "Dr. Sanjay Malhotra", experience: "17 years", rating: 4.8, image: "https://images.unsplash.com/photo-1582750433449-648ed127bb54?w=100&h=100&fit=crop&crop=face" }
     ],
     psychiatry: [
       { id: 10, name: "Dr. Arjun Kapoor", experience: "12 years", rating: 4.7, image: "https://images.unsplash.com/photo-1622253692010-333f2da6031d?w=100&h=100&fit=crop&crop=face" },
       { id: 11, name: "Dr. Meera Desai", experience: "15 years", rating: 4.9, image: "https://images.unsplash.com/photo-1594824947933-d0501ba2fe65?w=100&h=100&fit=crop&crop=face" }
     ]
   };
   
   return mockDoctors[specialty] || [];
 }

 // Select a doctor
 function selectDoctor(doctorCard, doctorId) {
   // Remove selected class from all doctor cards
   const allDoctorCards = document.querySelectorAll('.doctor-card');
   allDoctorCards.forEach(card => {
     card.classList.remove('selected');
   });
   
   // Add selected class to clicked doctor card
   doctorCard.classList.add('selected');
   
   // Set the selected doctor value
   document.getElementById('selectedDoctor').value = doctorId;
 }

 // Consultation type selection
 function selectConsultation(type) {
   const typeSelect = document.getElementById('consultationType');
   if (type === 'text') {
     typeSelect.value = 'text';
   } else if (type === 'audio') {
     typeSelect.value = 'audio';
   } else if (type === 'video') {
     typeSelect.value = 'video';
   } else if (type === 'offline') {
     typeSelect.value = 'offline';
   }
   
   // Handle the consultation type change
   handleConsultationTypeChange(type);
   
   // Scroll to booking form
   document.querySelector('.booking-section').scrollIntoView({ behavior: 'smooth' });
 }
 
 // Consultation tab switching
 function openConsultTab(tabName) {
   // Hide all tab content
   const tabContents = document.getElementsByClassName('consult-content');
   for (let i = 0; i < tabContents.length; i++) {
     tabContents[i].classList.remove('active');
   }
   
   // Remove active class from all tabs
   const tabButtons = document.getElementsByClassName('consult-tab');
   for (let i = 0; i < tabButtons.length; i++) {
     tabButtons[i].classList.remove('active');
   }
   
   // Show the specific tab content and activate the button
   document.getElementById(tabName).classList.add('active');
   event.currentTarget.classList.add('active');
 }
 
 // Booking form submission 
 //**
	// document.getElementById('bookingForm').addEventListener('submit', function(e) {
	  // e.preventDefault();
	   
	  // const consultationType = document.getElementById('consultationType').value;
	  // const specialty = document.getElementById('specialty').value;
	  // const selectedDoctor = document.getElementById('selectedDoctor').value;
	  // const selectedHospital = document.getElementById('selectedHospital').value;
	   //const date = document.getElementById('date').value;
	   //const time = document.getElementById('time').value;
	   
	  // if (consultationType && specialty && date && time) {
	   //  let message = `Appointment booked successfully!\n\nType: ${consultationType}\nSpecialty: ${specialty}\nDate: ${date}\nTime: ${time}`;
	     
	    // if (consultationType === 'offline' && selectedHospital) {
	     //  const hospitalName = document.querySelector('.hospital-card.selected .hospital-details h5').textContent;
	     //  message += `\nHospital: ${hospitalName}`;
	    // } else if (selectedDoctor) {
	    //   const doctorName = document.querySelector('.doctor-card.selected .doctor-details h5').textContent;
	   //    message += `\nDoctor: ${doctorName}`;
	   //  }
	     
	    // alert(message);
	    // this.reset();
	    // document.getElementById('doctorSelection').style.display = 'none';
	   //  document.getElementById('hospitalSelection').style.display = 'none';
	  // } else {
	 //    alert('Please fill in all required fields.');
	 //  }
	 //});
 ///
 
 // Set minimum date to today
 const today = new Date().toISOString().split('T')[0];
 document.getElementById('date').setAttribute('min', today);
 
 // Navbar scroll effect
 window.addEventListener('scroll', function() {
   if (window.scrollY > 50) {
     document.querySelector('.navbar').classList.add('scrolled');
   } else {
     document.querySelector('.navbar').classList.remove('scrolled');
   }
 });