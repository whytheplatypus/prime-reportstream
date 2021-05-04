describe( 'documentation', () => {
    before( () => {
        
        cy.visit( '/' );
    });

    it( 'should render', () => {        
        cy.get( '#signInButton').should('be.visible');    
        cy.get( '#navmenu').should('not.be.visible');
        cy.get( '#documentation' ).click();
        cy.title().should( 'contains',  'About ReportStream' )
    });

});