document.addEventListener('DOMContentLoaded', function() {
            const form = document.getElementById('signupForm');
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
                
                const fullName = document.getElementById('fullName').value.trim();
                const email = document.getElementById('email').value.trim();
                const password = document.getElementById('password').value;
                const confirmPassword = document.getElementById('confirmPassword').value;
                const agreeTerms = document.getElementById('agreeTerms').checked;
                
                let isValid = true;
                
                // Validate full name
                if (fullName === '') {
                    document.getElementById('nameError').style.display = 'block';
                    isValid = false;
                } else {
                    document.getElementById('nameError').style.display = 'none';
                }
                
                // Validate email
                const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
                if (!emailRegex.test(email)) {
                    document.getElementById('emailError').style.display = 'block';
                    isValid = false;
                } else {
                    document.getElementById('emailError').style.display = 'none';
                }
                
                // Validate password
                if (password.length < 8) {
                    document.getElementById('passwordError').style.display = 'block';
                    isValid = false;
                } else {
                    document.getElementById('passwordError').style.display = 'none';
                }
                
                // Validate confirm password
                if (password !== confirmPassword) {
                    document.getElementById('confirmError').style.display = 'block';
                    isValid = false;
                } else {
                    document.getElementById('confirmError').style.display = 'none';
                }
                
                // Validate terms agreement
                if (!agreeTerms) {
                    document.getElementById('termsError').style.display = 'block';
                    isValid = false;
                } else {
                    document.getElementById('termsError').style.display = 'none';
                }
                
                // If form is valid, show success message
                if (isValid) {
                    successMessage.style.display = 'block';
                    form.reset();
                    
                    // In a real application, you would submit the form data to a server here
                    setTimeout(() => {
                        successMessage.style.display = 'none';
                    }, 3000);
                }
            });
            
            // Real-time validation for password confirmation
            document.getElementById('confirmPassword').addEventListener('input', function() {
                const password = document.getElementById('password').value;
                const confirmPassword = this.value;
                
                if (password !== confirmPassword && confirmPassword !== '') {
                    document.getElementById('confirmError').style.display = 'block';
                } else {
                    document.getElementById('confirmError').style.display = 'none';
                }
            });
        });