import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PessoaDAO {
    private SessionFactory sessionFactory;

    public PessoaDAO() {
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    public void salvarPessoa(Pessoa pessoa) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(pessoa);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Pessoa buscarPessoaPorId(Long id) {
        Session session = sessionFactory.openSession();
        Pessoa pessoa = null;

        try {
            pessoa = session.get(Pessoa.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return pessoa;
    }

    public void fecharSessionFactory() {
        sessionFactory.close();
    }
}