import java.util.List;

public interface GenerarArchivosI<t> {
    void generarArchivo(List<t> transacciones, String path);
}
