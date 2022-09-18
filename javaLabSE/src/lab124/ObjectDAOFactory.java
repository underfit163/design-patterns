package lab124;

public class ObjectDAOFactory extends DAOFactory {
    @Override
    public DAO getDAO() {
        return new ObjectDAO();
    }
}
