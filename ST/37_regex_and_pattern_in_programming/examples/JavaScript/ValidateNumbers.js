function validateNumbers(str) {

    // regex pattern for  numbers
    const re =/^\d+$/;

    // check if the string contains only numbers
    let result = str.match(re);
    if (result) {
        console.log('The string contains only numbers.');
    }
    else {
        let str = prompt('Contains non-digits:');
        validateNumbers(str);
    }
}

// take input
let str = '3 bananas';

validateNumbers(str);