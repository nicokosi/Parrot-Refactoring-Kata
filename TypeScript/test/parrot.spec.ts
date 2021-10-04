import { expect } from "chai";
import "mocha";
import { Parrot, ParrotTypes } from "../src/parrot";

function createParrot(parrotType: ParrotTypes, numberOfCoconuts: number) {
    return new Parrot(parrotType, numberOfCoconuts, 0, false);
}

describe("Parrot", () => {

    it("gets speed of European Parrot", () => {
        const parrot = createParrot(ParrotTypes.EUROPEAN, 0);

        expect(parrot.getSpeed()).eql(12);
    });

    it("gets speed of African Parrot with one coconut", () => {
        const parrot = new Parrot(ParrotTypes.AFRICAN, 1, 0, false);

        expect(parrot.getSpeed()).eql(3);
    });

    it("gets speed of African Parrot with two coconuts", () => {
        const parrot = new Parrot(ParrotTypes.AFRICAN, 2, 0, false);

        expect(parrot.getSpeed()).eql(0);
    });

    it("gets speed of African Parrot with no coconuts", () => {
        const parrot = new Parrot(ParrotTypes.AFRICAN, 0, 0, false);

        expect(parrot.getSpeed()).eql(12);
    });

    it("gets speed of Norwegian Blue Parrot nailed", () => {
        const parrot = new Parrot(ParrotTypes.NORWEGIAN_BLUE, 0, 1.5, true);

        expect(parrot.getSpeed()).eql(0);
    });

    it("gets speed of Norwegian Blue Parrot not nailed", () => {
        const parrot = new Parrot(ParrotTypes.NORWEGIAN_BLUE, 0, 1.5, false);

        expect(parrot.getSpeed()).eql(18);
    });

    it("gets speed of Norwegian Blue Parrot not nailed high voltage", () => {
        const parrot = new Parrot(ParrotTypes.NORWEGIAN_BLUE, 0, 4, false);

        expect(parrot.getSpeed()).eql(24);
    });
});
