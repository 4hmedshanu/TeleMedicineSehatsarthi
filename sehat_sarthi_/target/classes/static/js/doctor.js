// Tab switching functionality
        document.querySelectorAll('.consult-tab').forEach(tab => {
            tab.addEventListener('click', function() {
                document.querySelectorAll('.consult-tab').forEach(t => t.classList.remove('active'));
                this.classList.add('active');
            });
        });

        // Start consultation buttons
        document.querySelectorAll('.btn-primary').forEach(btn => {
            if (btn.textContent.includes('Start Call')) {
                btn.addEventListener('click', function() {
                    const patientName = this.closest('.appointment-card').querySelector('h4').textContent;
                    alert(`Starting consultation with ${patientName}`);
                });
            }
        });

        // Update online status
        function updateOnlineStatus() {
            const statusIndicator = document.querySelector('.status-indicator span');
            const isOnline = Math.random() > 0.1; // 90% chance of being online
            if (isOnline) {
                statusIndicator.textContent = 'Online - Accepting Consultations';
                document.querySelector('.status-online').style.background = 'var(--success)';
            } else {
                statusIndicator.textContent = 'Offline - Not Accepting Consultations';
                document.querySelector('.status-online').style.background = 'var(--danger)';
            }
        }

        // Update status every 30 seconds (simulation)
        setInterval(updateOnlineStatus, 30000);