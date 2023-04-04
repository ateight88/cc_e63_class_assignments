/*

// #### Episode 1

// declare a const variable assigned to JSON object
const scenario = {
  murderer: 'Miss Scarlet',
  room: 'Library',
  weapon: 'Rope',
};

// declare variable assigned to an anonymous function
const declareMurderer = function () {
  // return a string template literal with an expression calling the murderer property/key of the scenario JSON object
  return `The murderer is ${scenario.murderer}.`;
};

// declare a variable  assigned the function call
const verdict = declareMurderer();

// log the output of variable
console.log(verdict); // Miss Scarlet

*/

/*

// #### Episode 2

// declare a const variale assigned to a string
const murderer = 'Professor Plum';

// declare const variable assigned to anonymoust function
const changeMurderer = function () {
  // re-assign const variable to a new string
  murderer = 'Mrs. Peacock'; // block scoped reassignment of a const variable, will cause error
};

// won't evaluate the below code

// decalre const variable to anonymoust function
const declareMurderer = function () {
  // return string template literal with the expression of variable assigned in previous block
  return `The murderer is ${murderer}.`; //only access to global scoped var of same name
};

// call function
changeMurderer(); 

// declare variable assigned to function call
const verdict = declareMurderer();

// log output
console.log(verdict);

*/

/*

// declare gloabl scoped let variable and assign a string
let murderer = 'Professor Plum';

// declare const variable to anonymous function
const declareMurderer = function () {
  // assign block scoped variable to a new value
  let murderer = 'Mrs. Peacock';
  // return string template literal with the expression variable murderer
  return `The murderer is ${murderer}.`;
};

// decalre variable assigned to function call
const firstVerdict = declareMurderer();
// log output
console.log('First Verdict: ', firstVerdict); // Mrs. Peacock

// decalre variable assigned to string template literal with expression containing the variable murderer which has access to the global scoped version
const secondVerdict = `The murderer is ${murderer}.`;
console.log('Second Verdict: ', secondVerdict); // Professor Plum

*/

/*

// #### Episode 4

// declare 3 global scoped let vars to different strings
let suspectOne = 'Miss Scarlet';
let suspectTwo = 'Professor Plum';
let suspectThree = 'Mrs. Peacock';

// declare const var to anonymoust function
const declareAllSuspects = function () {
  // assgin block scoped var to string
  let suspectThree = 'Colonel Mustard';
  // return string template literal with expression conatining values of the global scoped variables suspectOne and suspectTwo and local scoped var suspectThree
  return `The suspects are ${suspectOne}, ${suspectTwo}, ${suspectThree}.`;
};

// declare const var assigned to function call
const suspects = declareAllSuspects();

// log output of function
console.log(suspects); // Miss Scarlet, Professor Plum and Colonel Mustard

// log output of string template literal with expression containing the value of gloabl scoped var
console.log(`Suspect three is ${suspectThree}.`); // Mrs. Peacock

*/

/*

// declare const var, assigned to object
const scenario = {
  murderer: 'Miss Scarlet',
  room: 'Kitchen',
  weapon: 'Candle Stick',
};

// declare const var assigned to anonymous function
const changeWeapon = function (newWeapon) {
  // assign function parameter to object property value
  scenario.weapon = newWeapon;
};

// declare const variable to annoymous function with no parameters
const declareWeapon = function () {
  // return string template literal with expression containing the value of object property
  return `The weapon is the ${scenario.weapon}.`;
};

// call the function with an argument of 'Revolver' which assigns new value to the object property
changeWeapon('Revolver');

// declare const variable and assign to function call
const verdict = declareWeapon();

// log output of variable
console.log(verdict); // Revolver

*/

/* 

// declare global scope variable and assign to string
let murderer = 'Colonel Mustard';

// declare const variable assigned to annoymous function
const changeMurderer = function () {
  // re-assign global scoped variable
  murderer = 'Mr. Green';

  // declare const variable assigned to annoymous function
  const plotTwist = function () {
    // re-assign global scoped variable
    murderer = 'Mrs. White';
  };

  // call function to get updated value
  plotTwist(); // Mrs. White
};

// declare const variable assigned to annonymous function
const declareMurderer = function () {
  // return string template literal with expression containing updated value of variable 'murderer'
  return `The murderer is ${murderer}.`;
};

// call function
changeMurderer(); // Mrs. White

// declare const variable assigned to function call
const verdict = declareMurderer();

// log output
console.log(verdict); // Mrs. White

*/

/* 

// #### Episode 7

// global scope var
let murderer = 'Professor Plum';

const changeMurderer = function () {
  // re-assign global scope var
  murderer = 'Mr. Green';

  const plotTwist = function () {
    // assign block scoped var
    let murderer = 'Colonel Mustard';

    const unexpectedOutcome = function () {
      // re-assign block scoped var
      murderer = 'Miss Scarlet';
    };

    unexpectedOutcome(); // Miss Scarlet
  };

  // call function - gets value of first assigment
  plotTwist(); // Colonel Mustard
};

const declareMurderer = function () {
  // return first re-assign of global var
  return `The murderer is ${murderer}.`;
};

// return first re-assign of global var
changeMurderer();

// return first re-assign of global var
const verdict = declareMurderer();

// log output
console.log(verdict); // Mr. Green

*/

/*

// #### Episode 8

// initial scenario
const scenario = {
  murderer: 'Mrs. Peacock',
  room: 'Conservatory',
  weapon: 'Lead Pipe',
};

// update scenario stored in new var

// outer scope of function
const changeScenario = function () {
  // new values
  scenario.murderer = 'Mrs. Peacock';
  scenario.room = 'Dining Room';

  // nested fucntion
  // declare const and assign to function with parameter
  const plotTwist = function (room) {
    // condition with strict equality
    if (scenario.room === room) {
      scenario.murderer = 'Colonel Mustard';
    }

    // nested / nested function
    // declare const and assign to function with parameter
    const unexpectedOutcome = function (murderer) {
      // condition with strinct equality
      if (scenario.murderer === murderer) {
        scenario.weapon = 'Candle Stick';
      }
    };

    // nested plotTwist function scope - evaluates to true and changes the weapon
    unexpectedOutcome('Colonel Mustard');
  };

  // changeScenario function scope
  // evaluztes to true and changes the murderer to Colonel Mustard
  plotTwist('Dining Room');
};

// gloabl scope function
const declareWeapon = function () {
  return `The weapon is ${scenario.weapon}.`;
};

changeScenario(); //first Mrs. Peacock and Dining Room then plotTwist() evaluates true changing the value of murderer, then unexpectedOutcome() evaluates true changing the value of weapon

// const variable assigned to function call returning weapon
const verdict = declareWeapon();

// log output
console.log(verdict); // Candle Stick

*/

/*

// assign global scope variable
let murderer = 'Professor Plum';

if (murderer === 'Professor Plum') {
  // assign block scoped variable, never called
  let murderer = 'Mrs. Peacock';
}

const declareMurderer = function () {
  // return global scoped variable
  return `The murderer is ${murderer}.`;
};

// assign variable to function call
const verdict = declareMurderer();

// log output
console.log(verdict); // Professor Plum

*/
