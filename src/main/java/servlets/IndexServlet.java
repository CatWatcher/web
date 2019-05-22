package servlets;

import entity.News;
import repositories.NewsRepository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

// связующее звено
// получает запрос и отдает какой-то файл
// регистрация через аннотации
@WebServlet(
        name = "IndexServlet",
        urlPatterns = "/" // указывваем запрос на который сервлет должен обработать
)
public class IndexServlet extends HttpServlet {
    // для получения данных от репозитория
    private NewsRepository newsRepository;

    public IndexServlet() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("OrmExample");
        newsRepository = new NewsRepository(entityManagerFactory.createEntityManager());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // в этом методе получаем данные из базы
        // вставляем на страничку и отправляем пользователю
        RequestDispatcher view = req.getRequestDispatcher("index.jsp");
        List<News> allnews = newsRepository.getAllNews();
        req.setAttribute("allnews", allnews);
        view.forward(req, resp); // просто отправляем страничку без изменений
    }
}
