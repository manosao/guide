package gr.manos.guide.restapi.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Greeting {

	private String message;
}
