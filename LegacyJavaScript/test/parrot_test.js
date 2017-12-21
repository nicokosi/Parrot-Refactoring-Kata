/* global require, describe, it */

var expect = require('chai').expect;
var Parrot = require('../src/parrot');

describe("Parrot", function () {
    'use strict';

    it("gets speed of European Parrot", function () {
        var parrot = new Parrot.EuropeanParrot();

        expect(parrot.getSpeed()).eql(12);
    });

    it("gets speed of African Parrot with one coconut", function () {
        var parrot = new Parrot.AfricanParrot(1);

        expect(parrot.getSpeed()).eql(3);
    });

    it("gets speed of African Parrot with two coconuts", function () {
        var parrot = new Parrot.AfricanParrot(2);

        expect(parrot.getSpeed()).eql(0);
    });

    it("gets speed of African Parrot with no coconuts", function () {
        var parrot = new Parrot.AfricanParrot(0);

        expect(parrot.getSpeed()).eql(12);
    });

    it("gets speed of Norwegian Blue Parrot nailed", function () {
        var parrot = new Parrot.NorwegianBlueParrot(1.5, true);

        expect(parrot.getSpeed()).eql(0);
    });

    it("gets speed of Norwegian Blue Parrot not nailed", function () {
        var parrot = new Parrot.NorwegianBlueParrot(1.5, false);

        expect(parrot.getSpeed()).eql(18);
    });

    it("gets speed of Norwegian Blue Parrot not nailed high voltage", function () {
        var parrot = new Parrot.NorwegianBlueParrot(4, false);

        expect(parrot.getSpeed()).eql(24);
    });
});
