import java.util.List;

public interface CargarArchivosI<T> {
    List<T> loadData(String filePath);

}
