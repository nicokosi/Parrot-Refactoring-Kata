import { expect } from "chai";
import "mocha";
import {AfricanParrot, EuropeanParrot, NorwegianParrot} from "../src/parrot";

describe("Parrot", () => {

    it("gets speed of European Parrot", () => {
        const parrot = new EuropeanParrot();

        expect(parrot.getSpeed()).eql(12);
    });

    it("gets speed of African Parrot with one coconut", () => {
        const parrot = new AfricanParrot(1);

        expect(parrot.getSpeed()).eql(3);
    });

    it("gets speed of African Parrot with two coconuts", () => {
        const parrot = new AfricanParrot(2);

        expect(parrot.getSpeed()).eql(0);
    });

    it("gets speed of African Parrot with no coconuts", () => {
        const parrot = new AfricanParrot(0);

        expect(parrot.getSpeed()).eql(12);
    });

    it("gets speed of Norwegian Blue Parrot nailed", () => {
        const parrot = new NorwegianParrot(1.5, true);

        expect(parrot.getSpeed()).eql(0);
    });

    it("gets speed of Norwegian Blue Parrot not nailed", () => {
        const parrot = new NorwegianParrot(1.5, false);

        expect(parrot.getSpeed()).eql(18);
    });

    it("gets speed of Norwegian Blue Parrot not nailed high voltage", () => {
        const parrot = new NorwegianParrot(4, false);

        expect(parrot.getSpeed()).eql(24);
    });

    it("gets speed of Norwegian Blue Parrot can be negative when voltage is negative", () => {
        const parrot = new NorwegianParrot(-4, false);

        expect(parrot.getSpeed()).eql(-48);
    });
});
