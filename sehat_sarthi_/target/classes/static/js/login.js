 document.addEventListener('DOMContentLoaded', function() {
            const form = document.getElementById('loginForm');
            const passwordToggle = document.getElementById('passwordToggle');
            const passwordInput = document.getElementById('password');
            const successMessage = document.getElementById('successMessage');
            
            // Toggle password visibility
            passwordToggle.addEventListener('click', function() {
                const type = passwordInput.getAttribute('type') === 'password' ? 'text' : 'password';
                passwordInput.setAttribute('type', type);
                this.innerHTML = type === 'password' ? '<i class="far fa-eye"></i>' : '<i class="far fa-eye-slash"></i>';
            });
            
            // Form validation
            form.addEventListener('submit', function(e) {
                e.preventDefault();
                
                const email = document.getElementById('email').value.trim();
                const password = document.getElementById('password').value;
                
                let isValid = true;
                
                // Validate email
                const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
                if (!emailRegex.test(email)) {
                    document.getElementById('emailError').style.display = 'block';
                    isValid = false;
                } else {
                    document.getElementById('emailError').style.display = 'none';
                }
                
                // Validate password
                if (password === '') {
                    document.getElementById('passwordError').style.display = 'block';
                    isValid = false;
                } else {
                    document.getElementById('passwordError').style.display = 'none';
                }
                
                // If form is valid, show success message
                if (isValid) {
                    successMessage.style.display = 'block';
                    
                    // In a real application, you would submit the form data to a server here
                    // For demo purposes, we'll just reset the form after a delay
                    setTimeout(() => {
                        successMessage.style.display = 'none';
                        form.reset();
                    }, 3000);
                }
            });
            
            // Demo credentials for testing
            console.log("Demo credentials: user@example.com / password123");
        });