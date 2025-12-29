 // Quick Actions Functions
        function bookAppointment() {
            alert('Redirecting to appointment booking page...');
            // In actual implementation, redirect to booking page
        }
        
        function viewPrescriptions() {
            alert('Opening prescriptions dashboard...');
            // In actual implementation, show prescriptions
        }
        
        function viewRecords() {
            alert('Loading medical records...');
            // In actual implementation, show medical records
        }
        
        function viewReports() {
            alert('Opening lab reports...');
            // In actual implementation, show lab reports
        }
        
        function emergencyHelp() {
            if(confirm('Are you sure you want to call emergency services?')) {
                alert('Calling emergency services at 9368449862...');
                // In actual implementation, initiate emergency call
            }
        }
        
        function healthTracker() {
            alert('Opening health tracker...');
            // In actual implementation, show health tracker
        }
        
        // Join Consultation Button
        document.querySelectorAll('.btn-primary').forEach(btn => {
            if (btn.textContent.includes('Join Call')) {
                btn.addEventListener('click', function() {
                    const doctorName = this.closest('.appointment-card').querySelector('h4').textContent;
                    alert(`Joining consultation with ${doctorName}`);
                    // In actual implementation, start video/audio call
                });
            }
        });
        
        // Update health metrics (simulation)
        function updateHealthMetrics() {
            const heartRate = Math.floor(Math.random() * 20) + 65; // 65-85 bpm
            const systolic = Math.floor(Math.random() * 10) + 115; // 115-125
            const diastolic = Math.floor(Math.random() * 10) + 75; // 75-85
            const temp = (Math.random() * 1.5 + 97.5).toFixed(1); // 97.5-99.0
            const oxygen = Math.floor(Math.random() * 3) + 97; // 97-99%
            
            document.querySelector('.stat-value:nth-child(1)').textContent = heartRate;
            document.querySelector('.stat-value:nth-child(2)').textContent = `${systolic}/${diastolic}`;
            document.querySelector('.stat-value:nth-child(3)').textContent = `${temp}°F`;
            document.querySelector('.stat-value:nth-child(4)').textContent = `${oxygen}%`;
        }
        
        // Update metrics every 30 seconds (simulation)
        setInterval(updateHealthMetrics, 30000);
        
        // Medication reminder
        function checkMedicationReminders() {
            const now = new Date();
            const hours = now.getHours();
            
            if (hours === 9 || hours === 21) { // 9 AM and 9 PM
                alert('Medication Reminder: Time to take your prescribed medications.');
            }
        }
        
        // Check reminders every hour
        setInterval(checkMedicationReminders, 3600000);