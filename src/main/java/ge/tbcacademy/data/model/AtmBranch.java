package ge.tbcacademy.data.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class AtmBranch {
    private final int id;
    private final double latitude;
    private final double longitude;
    private final String address;
    private final String regionName;
    private final String type;
}