const Park = function (name, ticketPrice, dinosaurCollection) {
  this.name = name;
  this.ticketPrice = ticketPrice;
  this.dinosaurCollection = dinosaurCollection || [];
};

Park.prototype.addDino = function (dino) {
  return this.dinosaurCollection.push(dino);
};

Park.prototype.removeDino = function (dino) {
  const indexOfDino = this.dinosaurCollection.indexOf(dino);
  this.dinosaurCollection.splice(indexOfDino, 1);
};

Park.prototype.findMostVisitedDino = function () {
  // create var and assign to first element
  let mostVisitedDino = this.dinosaurCollection[0];
  // iterate length of array
  for (let i = 1; i < this.dinosaurCollection.length; i++) {
    // if > than first element
    if (
      this.dinosaurCollection[i].guestsAttractedPerDay >
      mostVisitedDino.guestsAttractedPerDay
    ) {
      // assign mostVisited to current index
      mostVisitedDino = this.dinosaurCollection[i];
    }
  }
  return mostVisitedDino;
};

Park.prototype.findDinosBySpecies = function (species) {
  // initialise var
  const dinosBySpecies = [];
  // iterate
  for (let i = 0; i < this.dinosaurCollection.length; i++) {
    // if input matches current index
    if (this.dinosaurCollection[i].species === species) {
      // add to dinosBySpecies
      dinosBySpecies.push(this.dinosaurCollection[i]);
    }
  }
  return dinosBySpecies;
};

Park.prototype.totalVisitsPerDay = function () {
  let totalVisitsPerDay = 0;
  // iterate
  for (let i = 0; i < this.dinosaurCollection.length; i++) {
    // sum guestsAttractedPerDay for each dino
    totalVisitsPerDay += this.dinosaurCollection[i].guestsAttractedPerDay;
  }
  return totalVisitsPerDay;
};

Park.prototype.totalVisitsPerYear = function () {
  return this.totalVisitsPerDay() * 365;
};

Park.prototype.totalRevenuePerYear = function () {
  return this.totalVisitsPerYear() * this.ticketPrice;
};

Park.prototype.removeDinoBySpecies = function (species) {
  // iterate over dinoCollection
  for (let i = 0; i < this.dinosaurCollection.length; i++) {
    // if input matches current index
    if (this.dinosaurCollection[i].species === species) {
      // remove
      this.dinosaurCollection.splice(i, 1);
      break; // exit after first occurrence
    }
  }
};

Park.prototype.countDinosByDiet = function () {
  // initialise object for diet types
  const dietCounts = { carnivore: 0, herbivore: 0, omnivore: 0 };
  // iterate over dinoCollection targeting diet property
  for (let i = 0; i < this.dinosaurCollection.length; i++) {
    // each occurence increments
    dietCounts[this.dinosaurCollection[i].diet]++;
  }
  return dietCounts;
};

module.exports = Park;
