const Traveller = function (journeys) {
  this.journeys = journeys;
};

Traveller.prototype.getJourneyStartLocations = function () {
  return this.journeys.map(journey => {
    return journey.startLocation;
  });
};

Traveller.prototype.getJourneyEndLocations = function () {
  return this.journeys.map(journey => {
    return journey.endLocation;
  });
};

Traveller.prototype.getJourneysByTransport = function (transport) {
  return this.journeys.filter(journey => {
    return journey.transport === transport;
  });
};

Traveller.prototype.getJourneysByMinDistance = function (minDistance) {
  return this.journeys.filter(journey => {
    return journey.distance > minDistance;
  });
};

Traveller.prototype.calculateTotalDistanceTravelled = function () {
  return this.journeys.reduce((total, journey) => {
    return (total += journey.distance);
  }, 0);
};

/* 

Get Unique... getUniqueModesOfTransport

Method 1
    array.filter((currentValue, index, arr) => (
		arr.indexOf(currentValue) === index
    ))

Method 2
    array.reduce((accumulator, currentValue) => (
    accumulator.includes(currentValue) ? accumulator : [...accumulator, currentValue]
  ), [])

Method 3
[...new Set(array)]  
*/

// Method 1
// Traveller.prototype.getUniqueModesOfTransport = function () {
//   return this.journeys
//     .map(journey => {
//       return journey.transport;
//     })
//     .filter((transport, index, arr) => {
//       return arr.indexOf(transport) === index;
//     });
// };

// Method 2
// Traveller.prototype.getUniqueModesOfTransport = function () {
//   return this.journeys
//     .map(journey => {
//       return journey.transport;
//     })
//     .reduce(
//       (accumulator, transport) =>
//         accumulator.includes(transport)
//           ? accumulator
//           : [...accumulator, transport],
//       []
//     );
// };

// Method 3
Traveller.prototype.getUniqueModesOfTransport = function () {
  return [
    ...new Set(
      this.journeys.map(journey => {
        return journey.transport;
      })
    ),
  ];
};

module.exports = Traveller;
