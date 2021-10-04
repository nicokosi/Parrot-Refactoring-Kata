import { expect } from "chai";
import "mocha";
import { AfricanParrot } from "../src/parrot-african";
import { EuropeanParrot } from "../src/parrot-european";
import { NorwegianBlueParrot } from "../src/parrot-norwegian-blue";

describe("Parrot", () => {

    it("gets speed of European Parrot", () => {
        const parrot = new EuropeanParrot(0, 0, false);

        expect(parrot.getSpeed()).eql(12);
    });

    it("gets speed of African Parrot with one coconut", () => {
        const parrot = new AfricanParrot(1, 0, false);

        expect(parrot.getSpeed()).eql(3);
    });

    it("gets speed of African Parrot with two coconuts", () => {
        const parrot = new AfricanParrot(2, 0, false);

        expect(parrot.getSpeed()).eql(0);
    });

    it("gets speed of African Parrot with no coconuts", () => {
        const parrot = new AfricanParrot(0, 0, false);

        expect(parrot.getSpeed()).eql(12);
    });

    it("gets speed of Norwegian Blue Parrot nailed", () => {
        const parrot = new NorwegianBlueParrot(0, 1.5, true);

        expect(parrot.getSpeed()).eql(0);
    });

    it("gets speed of Norwegian Blue Parrot not nailed", () => {
        const parrot = new NorwegianBlueParrot(0, 1.5, false);

        expect(parrot.getSpeed()).eql(18);
    });

    it("gets speed of Norwegian Blue Parrot not nailed high voltage", () => {
        const parrot = new NorwegianBlueParrot(0, 4, false);

        expect(parrot.getSpeed()).eql(24);
    });
});
