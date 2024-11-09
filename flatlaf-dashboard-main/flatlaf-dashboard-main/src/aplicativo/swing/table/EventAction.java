package aplicativo.swing.table;

import AdminEscuela.Modelo.ModelStudent;

public interface EventAction {

    public void delete(ModelStudent student);

    public void update(ModelStudent student);
}
