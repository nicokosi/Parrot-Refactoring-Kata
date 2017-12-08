unit Parrot;

interface

type
     TParrot = object
         constructor Init;
         function GetSpeed: Double; virtual;
         { private }
         function GetBaseSpeed: Double;
     end;
     PParrot = ^TParrot;

     TEuropeanParrot = object(TParrot)
         constructor Init;
         function GetSpeed: Double; virtual;
     end;
     PEuropeanParrot = ^TEuropeanParrot;

     TAfricanParrot = object(TParrot)
         NumberOfCoconuts: Word;

         constructor Init(NumberOfCoconutsIn: Word);
         function GetSpeed: Double; virtual;
         { private }
         function SlowdownDueCoconuts: Double;
         function GetLoadFactor: Double;
     end;
     PAfricanParrot = ^TAfricanParrot;

     TNorwegianBlueParrot = object(TParrot)
         Voltage: Double;
         IsNailed: Boolean;

         constructor Init(VoltageIn: Double; IsNailedIn: Boolean);
         function GetSpeed: Double; virtual;
         { private }
         function SpeedForVoltage: Double;
         function MaxSpeed: Double;
     end;
     PNorwegianBlueParrot = ^TNorwegianBlueParrot;

implementation

uses Math;

constructor TParrot.Init;
begin
    { existing constructor must be called, otherwise object is not initialized }
    Fail; {  abstract class }
end;

function TParrot.GetBaseSpeed: Double;
begin
    GetBaseSpeed := 12.0;
end;

function TParrot.GetSpeed: Double;
begin
    RunError(42); { Should be unreachable }
end;

constructor TEuropeanParrot.Init;
begin
    { needs empty constructor to initialise virtual table }
end;

function TEuropeanParrot.GetSpeed: Double;
begin
    GetSpeed := GetBaseSpeed;
end;

constructor TAfricanParrot.Init(NumberOfCoconutsIn: Word);
begin
    NumberOfCoconuts := NumberOfCoconutsIn;
end;

function TAfricanParrot.GetSpeed: Double;
begin
    GetSpeed := Math.Max(0.0, GetBaseSpeed - SlowdownDueCoconuts);
end;

function TAfricanParrot.SlowdownDueCoconuts: Double;
begin
    SlowdownDueCoconuts := GetLoadFactor * NumberOfCoconuts;
end;

function TAfricanParrot.GetLoadFactor: Double;
begin
    GetLoadFactor := 9.0;
end;

constructor TNorwegianBlueParrot.Init(VoltageIn: Double; IsNailedIn: Boolean);
begin
    Self.Voltage := VoltageIn;
    Self.IsNailed := IsNailedIn;
end;

function TNorwegianBlueParrot.GetSpeed: Double;
begin
    if Self.IsNailed then
    begin
        GetSpeed := 0.0;
    end
    else
    begin
        GetSpeed := Self.SpeedForVoltage;
    end;
end;

function TNorwegianBlueParrot.SpeedForVoltage: Double;
begin
    SpeedForVoltage := Math.Min(Self.MaxSpeed, Self.Voltage * Self.GetBaseSpeed);
end;

function TNorwegianBlueParrot.MaxSpeed: Double;
begin
    MaxSpeed := 24.0;
end;

end.
