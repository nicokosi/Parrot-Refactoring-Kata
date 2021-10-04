const ZERO: f32 = 0.0;

struct NorwegianBlueParrot {
    parrot_type: &'static str,
    number_of_coconuts: usize,
    voltage: f32,
    nailed: bool,
}

struct EuropeanParrot {
    parrot_type: &'static str,
    number_of_coconuts: usize,
    voltage: f32,
    nailed: bool,
}

struct AfricanParrot {
    parrot_type: &'static str,
    number_of_coconuts: usize,
    voltage: f32,
    nailed: bool,
}

trait Parrot {
    fn speed(&self) -> Result<f32, &'static str>;
}

impl Parrot for NorwegianBlueParrot {
    fn speed(&self) -> Result<f32, &'static str> {
        if self.nailed == true {
            Ok(ZERO)
        } else {
            Ok(compute_base_speed_for_voltage(self.voltage))
        }
    }
}

impl Parrot for EuropeanParrot {
    fn speed(&self) -> Result<f32, &'static str> {
        Ok(base_speed())
    }
}

impl Parrot for AfricanParrot {
    fn speed(&self) -> Result<f32, &'static str> {
        let african_speed = base_speed() - load_factor() * self.number_of_coconuts as f32;
        Ok(positive_speed_or_zero(african_speed))
    }
}

fn positive_speed_or_zero(speed: f32) -> f32 {
    if speed > ZERO { speed } else { ZERO }
}

fn compute_base_speed_for_voltage(voltage: f32) -> f32 {
    let fixed_base_speed = 24.0;
    let base_speed_for_voltage = voltage * base_speed();
    if base_speed_for_voltage < fixed_base_speed {
        base_speed_for_voltage
    } else {
        fixed_base_speed
    }
}

fn load_factor() -> f32 {
    9.0
}

fn base_speed() -> f32 {
    12.0
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn european_parrot_speed() {
        let parrot = EuropeanParrot {
            parrot_type: "european_parrot",
            number_of_coconuts: 0,
            voltage: 0.0,
            nailed: false,
        };
        assert_eq!(parrot.speed().unwrap(), 12.0);
    }

    #[test]
    fn african_parrot_speed_with_one_coconut() {
        let parrot = AfricanParrot {
            parrot_type: "african_parrot",
            number_of_coconuts: 1,
            voltage: 0.0,
            nailed: false,
        };
        assert_eq!(parrot.speed().unwrap(), 3.0);
    }

    #[test]
    fn african_parrot_speed_with_two_coconut() {
        let parrot = AfricanParrot {
            parrot_type: "african_parrot",
            number_of_coconuts: 2,
            voltage: 0.0,
            nailed: false,
        };
        assert_eq!(parrot.speed().unwrap(), 0.0);
    }

    #[test]
    fn african_parrot_speed_with_no_coconut() {
        let parrot = AfricanParrot {
            parrot_type: "african_parrot",
            number_of_coconuts: 0,
            voltage: 0.0,
            nailed: false,
        };
        assert_eq!(parrot.speed().unwrap(), 12.0);
    }

    #[test]
    fn nailed_norwegian_blue_parrot() {
        let parrot = NorwegianBlueParrot {
            parrot_type: "norwegian_blue_parrot",
            number_of_coconuts: 0,
            voltage: 1.5,
            nailed: true,
        };
        assert_eq!(parrot.speed().unwrap(), 0.0);
    }

    #[test]
    fn not_nailed_norwegian_blue_parrot() {
        let parrot = NorwegianBlueParrot {
            parrot_type: "norwegian_blue_parrot",
            number_of_coconuts: 0,
            voltage: 1.5,
            nailed: false,
        };
        assert_eq!(parrot.speed().unwrap(), 18.0);
    }

    #[test]
    fn not_nailed_norwegian_blue_parrot_with_high_voltage() {
        let parrot = NorwegianBlueParrot {
            parrot_type: "norwegian_blue_parrot",
            number_of_coconuts: 0,
            voltage: 4.0,
            nailed: false,
        };
        assert_eq!(parrot.speed().unwrap(), 24.0);
    }
}
