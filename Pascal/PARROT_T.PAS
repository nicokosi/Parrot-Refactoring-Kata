{F+} { need to set Far Calls in Compiler Options too }
program Parrot_T;

uses TPUnit, Parrot;

const Ulp = 1E-16;

var P: PParrot;

procedure Cleanup;
begin
    if P <> nil then
    begin
        Dispose(P);
        P := nil;
    end;
end;

procedure GetSpeedOfEuropeanParrot;
begin
    P := New(PEuropeanParrot, Init);
    AssertEqualsDouble('Speed', 12.0, P^.GetSpeed, Ulp);
end;

procedure GetSpeedOfAfricanParrotWithOneCoconut;
begin
    P := New(PAfricanParrot, Init(1));
    AssertEqualsDouble('Speed', 3.0, P^.GetSpeed, Ulp);
end;

procedure GetSpeedOfAfricanParrotWithTwoCoconuts;
begin
    P := New(PAfricanParrot, Init(2));
    AssertEqualsDouble('Speed', 0.0, P^.GetSpeed, Ulp);
end;

procedure GetSpeedOfAfricanParrotWithNoCoconuts;
begin
    P := New(PAfricanParrot, Init(0));
    AssertEqualsDouble('Speed', 12.0, P^.GetSpeed, Ulp);
end;

procedure GetSpeedNorwegianBlueParrotNailed;
begin
    P := New(PNorwegianBlueParrot, Init(1.5, True));
    AssertEqualsDouble('Speed', 0.0, P^.GetSpeed, Ulp);
end;

procedure GetSpeedNorwegianBlueParrotNotNailed;
begin
    P := New(PNorwegianBlueParrot, Init(1.5, False));
    AssertEqualsDouble('Speed', 18.0, P^.GetSpeed, Ulp);
end;

procedure GetSpeedNorwegianBlueParrotHighVoltage;
begin
    P := New(PNorwegianBlueParrot, Init(4, False));
    AssertEqualsDouble('Speed', 24.0, P^.GetSpeed, Ulp);
end;

procedure ParrotIsUnreachable;
begin
    P := New(PParrot, Init);
    AssertNil('failed constructor', P);
end;

begin
    RunFixtures('GetSpeedOfEuropeanParrot', Empty, GetSpeedOfEuropeanParrot, Cleanup);
    RunFixtures('GetSpeedOfAfricanParrotWithOneCoconut', Empty, GetSpeedOfAfricanParrotWithOneCoconut, Cleanup);
    RunFixtures('GetSpeedOfAfricanParrotWithTwoCoconuts', Empty, GetSpeedOfAfricanParrotWithTwoCoconuts, Cleanup);
    RunFixtures('GetSpeedOfAfricanParrotWithNoCoconuts', Empty, GetSpeedOfAfricanParrotWithNoCoconuts, Cleanup);
    RunFixtures('GetSpeedNorwegianBlueParrotNailed', Empty, GetSpeedNorwegianBlueParrotNailed, Cleanup);
    RunFixtures('GetSpeedNorwegianBlueParrotNotNailed', Empty, GetSpeedNorwegianBlueParrotNotNailed, Cleanup);
    RunFixtures('GetSpeedNorwegianBlueParrotNotNailedHighVoltage', Empty, GetSpeedNorwegianBlueParrotHighVoltage, Cleanup);
    RunFixtures('ParrotIsUnreachable', Empty, ParrotIsUnreachable, Cleanup);
end.
