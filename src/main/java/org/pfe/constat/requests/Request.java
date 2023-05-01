package org.pfe.constat.requests;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class Request {
  @JsonProperty("expert_validation")
  private ExpertValidation expertValidation;
  @JsonCreator
  public Request(@JsonProperty("expert_validation") ExpertValidation expertValidation) {
    this.expertValidation = expertValidation;
  }
  @Getter
  public static class ExpertValidation {
    @JsonProperty("avis")
    private String avis;
  }

}
