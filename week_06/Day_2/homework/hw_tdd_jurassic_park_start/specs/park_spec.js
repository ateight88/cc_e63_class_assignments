const assert = require('assert');
const Park = require('../models/park.js');
const Dinosaur = require('../models/dinosaur.js');

describe('Park', () => {
  let park;
  let dinosaur;

  beforeEach(() => {
    park = new Park('Dino Land', 400);
    dino1 = new Dinosaur('velociraptor', 'carnivore', 150);
    dino2 = new Dinosaur('stegosaurus', 'herbivore', 50);
  });

  it('should have a name', () => {
    const actual = park.name;
    assert.strictEqual(actual, 'Dino Land');
  });

  it('should have a ticket price', () => {
    const actual = park.ticketPrice;
    assert.strictEqual(actual, 400);
  });

  it('should have a collection of dinosaurs', function () {
    const actual = park.dinosaurCollection;
    assert.deepStrictEqual(actual, []);
  });

  it('should be able to add a dinosaur to its collection', () => {
    park.addDino(dino1);
    park.addDino(dino2);
    const actual = park.dinosaurCollection.length;
    assert.strictEqual(actual, 2);
  });

  it('should be able to remove a dinosaur from its collection', () => {
    park.addDino(dino1);
    park.addDino(dino2);
    park.removeDino(dino1);
    const actual = park.dinosaurCollection.length;
    assert.strictEqual(actual, 1);
  });

  it('should be able to find the dinosaur that attracts the most visitors', () => {
    park.addDino(dino1);
    park.addDino(dino2);
    const actual = park.findMostVisitedDino();
    assert.strictEqual(actual, dino1);
  });

  it('should be able to find all dinosaurs of a particular species', () => {
    const dino3 = new Dinosaur('stegosaurus', 'herbivore', 50);
    const dino4 = new Dinosaur('stegosaurus', 'herbivore', 50);
    park.addDino(dino3);
    park.addDino(dino4);
    const actual = park.findDinosBySpecies('stegosaurus');
    assert.deepStrictEqual(actual, [dino3, dino4]);
  });

  it('should be able to calculate the total number of visitors per day', () => {
    const dino3 = new Dinosaur('t-rex', 'carnivore', 100);
    const dino4 = new Dinosaur('t-rex', 'carnivore', 200);
    park.addDino(dino3);
    park.addDino(dino4);
    const actual = park.totalVisitsPerDay();
    assert.strictEqual(actual, 300);
  });

  it('should be able to calculate the total number of visitors per year', () => {
    const dino3 = new Dinosaur('velociraptor', 'carnivore', 150);
    park.addDino(dino3);
    const actual = park.totalVisitsPerYear();
    assert.strictEqual(actual, 54750);
  });

  it('should be able to calculate total revenue for one year', () => {
    const dino3 = new Dinosaur('velociraptor', 'carnivore', 150);
    park.addDino(dino3);
    const actual = park.totalRevenuePerYear();
    assert.strictEqual(actual, 21900000);
  });
});
