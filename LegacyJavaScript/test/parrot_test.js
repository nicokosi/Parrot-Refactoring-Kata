/* global require, describe, it */

var expect = require('chai').expect;
var parrots = require('../src/parrot');

describe("Parrot", function() {
    'use strict';

    it("gets speed of European Parrot", function() {
        var parrot = new parrots.EuropeanParrot();

        expect(parrot.getSpeed()).eql(12);
    });

    it("gets speed of African Parrot with one coconut", function() {
        var parrot = new parrots.AfricanParrot(1);

        expect(parrot.getSpeed()).eql(3);
    });

    it("gets speed of African Parrot with two coconuts", function() {
        var parrot = new parrots.AfricanParrot(2);

        expect(parrot.getSpeed()).eql(0);
    });

    it("gets speed of African Parrot with no coconuts", function() {
        var parrot = new parrots.AfricanParrot(0);

        expect(parrot.getSpeed()).eql(12);
    });

    it("gets speed of Norwegian Blue Parrot nailed", function() {
        var parrot = new parrots.NorwegianBlueParrot(1.5, true);

        expect(parrot.getSpeed()).eql(0);
    });

    it("gets speed of Norwegian Blue Parrot not nailed", function() {
        var parrot = new parrots.NorwegianBlueParrot(1.5, false);

        expect(parrot.getSpeed()).eql(18);
    });

    it("gets speed of Norwegian Blue Parrot not nailed high voltage", function() {
        var parrot = new parrots.NorwegianBlueParrot(4, false);

        expect(parrot.getSpeed()).eql(24);
    });
});
