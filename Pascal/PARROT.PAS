unit Parrot;

interface

type
     TParrotType = (European, African, NorwegianBlue);
     TParrot = object
         ParrotType: TParrotType;
         Voltage: Double;
         IsNailed: Boolean;

         constructor Init(ParrotTypeIn: TParrotType; NumberOfCoconutsIn: Word; VoltageIn: Double; IsNailedIn: Boolean);
         function GetSpeed: Double; virtual;
         { private }
         function GetBaseSpeed: Double;
         function GetBaseSpeedForVoltage(VoltageIn: Double): Double;
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
         function GetLoadFactor: Double;
     end;
     PAfricanParrot = ^TAfricanParrot;

     TNorwegianBlueParrot = object(TParrot)
         constructor Init(VoltageIn: Double; IsNailedIn: Boolean);
     end;
     PNorwegianBlueParrot = ^TNorwegianBlueParrot;

implementation

uses Math;

constructor TParrot.Init(ParrotTypeIn: TParrotType; NumberOfCoconutsIn: Word; VoltageIn: Double; IsNailedIn: Boolean);
begin
    Self.ParrotType := ParrotTypeIn;
    Self.Voltage := VoltageIn;
    Self.IsNailed := IsNailedIn;
end;

function TParrot.GetBaseSpeed: Double;
begin
    GetBaseSpeed := 12.0;
end;

function TAfricanParrot.GetLoadFactor: Double;
begin
    GetLoadFactor := 9.0;
end;

function TParrot.GetBaseSpeedForVoltage(VoltageIn: Double): Double;
begin
    GetBaseSpeedForVoltage := Math.Min(24.0, VoltageIn * Self.GetBaseSpeed);
end;

function TParrot.GetSpeed: Double;
begin
    if Self.ParrotType = NorwegianBlue then
    begin
        if Self.IsNailed then
        begin
            GetSpeed := 0.0;
        end
        else
        begin
            GetSpeed := Self.GetBaseSpeedForVoltage(Self.Voltage);
        end;
    end
    else
    begin
        RunError(42); { Should be unreachable }
    end;
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
    Self.NumberOfCoconuts := NumberOfCoconutsIn;
end;

function TAfricanParrot.GetSpeed: Double;
begin
    GetSpeed := Math.Max(0.0, Self.GetBaseSpeed - Self.GetLoadFactor * Self.NumberOfCoconuts);
end;

constructor TNorwegianBlueParrot.Init(VoltageIn: Double; IsNailedIn: Boolean);
begin
    TParrot.Init(NorwegianBlue, 0, VoltageIn, IsNailedIn);
end;


end.
