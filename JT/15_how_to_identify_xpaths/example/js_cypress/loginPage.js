/*
Cypress commands like cy.get(), cy.contains(), and cy.xpath() are used based on the recommended approach.
The usage of cy.get() and cy.contains() enhances readability and maintains a clear structure for the test.
XPath is used sparingly and only when necessary, for example, when clicking the "Forgot Password" link.
*/

describe('Login Page Tests', () => {
    beforeEach(() => {
        // Visit the login page
        cy.visit('https://example.com/login');
    });

    it('Successful Login with cy.get()', () => {
        // Type into username and password fields using cy.get()
        cy.get('#username').type('valid_username');
        cy.get('#password').type('valid_password');

        // Click the login button using cy.get()
        cy.get('button[type="submit"]').click();

        // Assert the successful login
        cy.url().should('eq', 'https://example.com/dashboard');
    });

    it('Failed Login with cy.contains()', () => {
        // Type into username and password fields using cy.contains()
        cy.contains('Username').next('input').type('invalid_username');
        cy.contains('Password').next('input').type('invalid_password');

        // Click the login button using cy.contains()
        cy.contains('Login').click();

        // Assert the login failure
        cy.get('.error-message').should('be.visible').and('contain', 'Invalid credentials');
    });

    it('Forgot Password Link', () => {
        // Click the "Forgot Password" link using XPath as a fallback
        cy.xpath('//a[text()="Forgot Password"]').click();

        // Assert navigation to the forgot password page
        cy.url().should('eq', 'https://example.com/forgot-password');
    });

    it('Validate Placeholder Text with cy.get()', () => {
        // Validate placeholder text using cy.get()
        cy.get('#username').should('have.attr', 'placeholder', 'Enter your username');
        cy.get('#password').should('have.attr', 'placeholder', 'Enter your password');
    });
});