// ============================================
// About Section Image Slider
// ============================================
document.addEventListener('DOMContentLoaded', function() {
    const slides = document.querySelectorAll('.slide');
    let currentSlide = 0;

    function showSlide(index) {
        slides.forEach(slide => slide.classList.remove('active'));
        slides[index].classList.add('active');
    }

    function nextSlide() {
        currentSlide = (currentSlide + 1) % slides.length;
        showSlide(currentSlide);
    }

    // Auto slide every 3 seconds
    setInterval(nextSlide, 3000);
});

// ============================================
// Navbar Scroll Effect
// ============================================
const navbar = document.getElementById('navbar');
let lastScroll = 0;

window.addEventListener('scroll', () => {
    const currentScroll = window.pageYOffset;
    
    if (currentScroll > 50) {
        navbar.classList.add('scrolled');
    } else {
        navbar.classList.remove('scrolled');
    }
    
    lastScroll = currentScroll;
});

// ============================================
// Mobile Menu Toggle
// ============================================
const hamburger = document.getElementById('hamburger');
const navMenu = document.getElementById('navMenu');

hamburger.addEventListener('click', () => {
    hamburger.classList.toggle('active');
    navMenu.classList.toggle('active');
});

// Close mobile menu when clicking on a link
document.querySelectorAll('.nav-menu a').forEach(link => {
    link.addEventListener('click', () => {
        hamburger.classList.remove('active');
        navMenu.classList.remove('active');
    });
});

// ============================================
// Smooth Scrolling for Navigation Links
// ============================================
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function (e) {
        e.preventDefault();
        const target = document.querySelector(this.getAttribute('href'));
        
        if (target) {
            const navHeight = navbar.offsetHeight;
            const targetPosition = target.offsetTop - navHeight;
            
            window.scrollTo({
                top: targetPosition,
                behavior: 'smooth'
            });
        }
    });
});

// ============================================
// Testimonials Slider
// ============================================
const testimonialCards = document.querySelectorAll('.testimonial-card');
const prevBtn = document.getElementById('prevBtn');
const nextBtn = document.getElementById('nextBtn');
let currentTestimonial = 0;

function showTestimonial(index) {
    testimonialCards.forEach((card, i) => {
        card.classList.remove('active');
        if (i === index) {
            card.classList.add('active');
        }
    });
}

function nextTestimonial() {
    currentTestimonial = (currentTestimonial + 1) % testimonialCards.length;
    showTestimonial(currentTestimonial);
}

function prevTestimonial() {
    currentTestimonial = (currentTestimonial - 1 + testimonialCards.length) % testimonialCards.length;
    showTestimonial(currentTestimonial);
}

if (nextBtn && prevBtn) {
    nextBtn.addEventListener('click', nextTestimonial);
    prevBtn.addEventListener('click', prevTestimonial);
    
    // Auto-slide testimonials every 5 seconds
    setInterval(nextTestimonial, 5000);
}

// ============================================
// Chatbot Toggle
// ============================================
const chatbotBtn = document.getElementById('chatbotBtn');
const chatbotPopup = document.getElementById('chatbotPopup');
const closeChatbot = document.getElementById('closeChatbot');

chatbotBtn.addEventListener('click', () => {
    chatbotPopup.classList.toggle('active');
});

closeChatbot.addEventListener('click', () => {
    chatbotPopup.classList.remove('active');
});

// Close chatbot when clicking outside
document.addEventListener('click', (e) => {
    if (!chatbotPopup.contains(e.target) && !chatbotBtn.contains(e.target)) {
        chatbotPopup.classList.remove('active');
    }
});

// ============================================
// Scroll Animation for Elements
// ============================================
const observerOptions = {
    threshold: 0.1,
    rootMargin: '0px 0px -100px 0px'
};

const observer = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
        if (entry.isIntersecting) {
            entry.target.classList.add('fade-in');
            observer.unobserve(entry.target);
        }
    });
}, observerOptions);

// Observe elements for animation
const animateElements = document.querySelectorAll('.service-card, .doctor-card, .future-card, .about-image, .about-text');
animateElements.forEach(el => observer.observe(el));

// ============================================
// Button Click Effects
// ============================================
document.querySelectorAll('.btn').forEach(button => {
    button.addEventListener('click', function(e) {
        // Create ripple effect
        const ripple = document.createElement('span');
        const rect = this.getBoundingClientRect();
        const size = Math.max(rect.width, rect.height);
        const x = e.clientX - rect.left - size / 2;
        const y = e.clientY - rect.top - size / 2;
        
        ripple.style.width = ripple.style.height = size + 'px';
        ripple.style.left = x + 'px';
        ripple.style.top = y + 'px';
        ripple.classList.add('ripple');
        
        this.appendChild(ripple);
        
        setTimeout(() => ripple.remove(), 600);
    });
});

// ============================================
// Stats Counter Animation
// ============================================
function animateCounter(element, target, duration) {
    let start = 0;
    const increment = target / (duration / 16);
    
    const timer = setInterval(() => {
        start += increment;
        if (start >= target) {
            element.textContent = target + '+';
            clearInterval(timer);
        } else {
            element.textContent = Math.floor(start) + '+';
        }
    }, 16);
}

// Animate stats when they come into view
const statsObserver = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
        if (entry.isIntersecting) {
            const statItems = entry.target.querySelectorAll('.stat-item h3');
            statItems.forEach(item => {
                const target = parseInt(item.textContent.replace(/\D/g, ''));
                animateCounter(item, target, 2000);
            });
            statsObserver.unobserve(entry.target);
        }
    });
}, { threshold: 0.5 });

const statsSection = document.querySelector('.stats');
if (statsSection) {
    statsObserver.observe(statsSection);
}

// ============================================
// Form Validation (for future contact forms)
// ============================================
function validateEmail(email) {
    const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return re.test(email);
}

function validatePhone(phone) {
    const re = /^[0-9]{10}$/;
    return re.test(phone.replace(/\D/g, ''));
}

// ============================================
// Lazy Loading Images
// ============================================
if ('IntersectionObserver' in window) {
    const imageObserver = new IntersectionObserver((entries, observer) => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                const img = entry.target;
                img.src = img.dataset.src || img.src;
                img.classList.add('loaded');
                imageObserver.unobserve(img);
            }
        });
    });

    document.querySelectorAll('img').forEach(img => imageObserver.observe(img));
}

// ============================================
// Chatbot Basic Functionality
// ============================================
const chatbotInput = document.querySelector('.chatbot-footer input');
const chatbotSendBtn = document.querySelector('.chatbot-footer button');
const chatbotBody = document.querySelector('.chatbot-body');

function addMessage(message, isBot = false) {
    const messageDiv = document.createElement('div');
    messageDiv.classList.add('chat-message');
    if (isBot) messageDiv.classList.add('bot');
    
    const p = document.createElement('p');
    p.textContent = message;
    messageDiv.appendChild(p);
    
    chatbotBody.appendChild(messageDiv);
    chatbotBody.scrollTop = chatbotBody.scrollHeight;
}

function handleChatbotMessage() {
    const message = chatbotInput.value.trim();
    if (message) {
        addMessage(message, false);
        chatbotInput.value = '';
        
        // Simulate bot response
        setTimeout(() => {
            const responses = [
                "Thank you for your message. Our medical team will assist you shortly.",
                "I understand your concern. Would you like to book an appointment?",
                "For immediate medical emergencies, please call 1800-123-4567.",
                "I can help you with appointment booking, doctor consultation, or medicine orders."
            ];
            const randomResponse = responses[Math.floor(Math.random() * responses.length)];
            addMessage(randomResponse, true);
        }, 1000);
    }
}

if (chatbotSendBtn) {
    chatbotSendBtn.addEventListener('click', handleChatbotMessage);
}

if (chatbotInput) {
    chatbotInput.addEventListener('keypress', (e) => {
        if (e.key === 'Enter') {
            handleChatbotMessage();
        }
    });
}

// ============================================
// Page Load Animation
// ============================================
window.addEventListener('load', () => {
    document.body.classList.add('loaded');
});

// ============================================
// Service Worker Registration (for PWA - optional)
// ============================================
if ('serviceWorker' in navigator) {
    window.addEventListener('load', () => {
        // Uncomment below to register service worker
        // navigator.serviceWorker.register('/sw.js')
        //     .then(reg => console.log('Service Worker registered'))
        //     .catch(err => console.log('Service Worker registration failed'));
    });
}

// ============================================
// Console Message
// ============================================
console.log('%cTele Medicine', 'color: #006A67; font-size: 24px; font-weight: bold;');
console.log('%cBringing Healthcare to Remote Areas', 'color: #00a39e; font-size: 14px;');
console.log('Website developed with modern web technologies');

// ============================================
// Performance Monitoring (Optional)
// ============================================
if ('performance' in window) {
    window.addEventListener('load', () => {
        setTimeout(() => {
            const perfData = window.performance.timing;
            const pageLoadTime = perfData.loadEventEnd - perfData.navigationStart;
            console.log(`Page Load Time: ${pageLoadTime}ms`);
        }, 0);
    });
}

const registerBtn = document.querySelector('.register-btn');
const popup = document.querySelector('.register-popup');

// जब mouse register button पर जाए — popup दिखाओ
registerBtn.addEventListener('mouseenter', () => {
    popup.classList.add('show');
});

// जब mouse popup के अंदर हो — कुछ मत करो
popup.addEventListener('mouseenter', () => {
    popup.classList.add('show');
});

// जब user कहीं और क्लिक करे — popup बंद कर दो
document.addEventListener('click', (e) => {
    if (!e.target.closest('.register-dropdown')) {
        popup.classList.remove('show');
    }
});

// Optional: Register button क्लिक करने पर भी popup toggle हो
registerBtn.addEventListener('click', (e) => {
    e.preventDefault();
    popup.classList.toggle('show');
});



