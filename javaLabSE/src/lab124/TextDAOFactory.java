package lab124;

public class TextDAOFactory extends DAOFactory {
    @Override
    public DAO getDAO() {
        return new TextDAO();
    }
}
