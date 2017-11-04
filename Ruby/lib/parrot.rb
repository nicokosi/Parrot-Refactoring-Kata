class Parrot

  def initialize type, number_of_coconuts, voltage, nailed
    @type = type
    @number_of_coconuts = number_of_coconuts
    @voltage = voltage
    @nailed = nailed
  end

  def speed
    case @type
    when :african_parrot
      return [0, base_speed - load_factor * @number_of_coconuts].max
    when :norwegian_blue_parrot
      return (@nailed) ? 0 : compute_base_speed_for_voltage(@voltage)
    end

    throw "Should be unreachable!"
  end

  private

  def compute_base_speed_for_voltage voltage
    [24.0, voltage * base_speed].min
  end

  def load_factor
    9.0
  end

  protected
  
  def base_speed
    12.0
  end
end

class EuropeanParrot < Parrot

  def initialize 
  end

  def speed
    return base_speed
  end
  
end

class AfricanParrot < Parrot

  def initialize type, number_of_coconuts, voltage, nailed
    @number_of_coconuts = number_of_coconuts
  end

  def speed
    return [0, base_speed - load_factor * @number_of_coconuts].max
  end

  private

  def load_factor
    9.0
  end
   
end
