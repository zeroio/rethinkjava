package z.rethink.ql;

public class LongLat implements ToJson {
    private final double lon;
    private final double lat;

    private LongLat(double lon, double lat) {
        this.lon = lon;
        this.lat = lat;
    }

    @Override
    public void toJson(StringBuilder sb) {
        sb.append("[").append(String.valueOf(lon)).append(",").append(String.valueOf(lat)).append("]");
    }
}
