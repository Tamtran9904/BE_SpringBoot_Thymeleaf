package fa.training.example.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.modelmapper.AbstractConverter;

public class StringToLocalDateConverter extends AbstractConverter<String, LocalDate> {

  private final DateTimeFormatter dateFormat;

  public StringToLocalDateConverter(String formater) {
    this.dateFormat = DateTimeFormatter.ofPattern(formater);
  }

  @Override
  protected LocalDate convert(String s) {
    return LocalDate.parse(s, dateFormat);
  }
}
