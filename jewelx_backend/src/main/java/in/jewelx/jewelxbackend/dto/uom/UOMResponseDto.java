package in.jewelx.jewelxbackend.dto.uom;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UOMResponseDto {
	private Long uomId;

    private String uomCode;

    private String uomName;

    private String description;
}
