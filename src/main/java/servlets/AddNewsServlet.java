package servlets;

import entity.News;
import repositories.NewsRepository;

import javax.enterprise.inject.New;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "AddNews",
        urlPatterns = "/addNews"
)
public class AddNewsServlet extends HttpServlet {
    private NewsRepository newsRepository;

    public AddNewsServlet() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("OrmExample");
        newsRepository = new NewsRepository(entityManagerFactory.createEntityManager());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher("addNews.jsp");
        req.setAttribute("addinfo", "To add news use form below");
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // тут должны получить данные из формы
        // проверить и отправить в базу
        // пишем переменную, которую записали в нейм
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        // формируем объект новости
        News news = new News();
        news.setTitle(title);
        news.setText(description);
        // добавляем новость
        newsRepository.addNews(news);
        // возвращаем пользователю ту же страничку
        RequestDispatcher view = req.getRequestDispatcher("addNews.jsp");
        req.setAttribute("addinfo", "Article '" + title + "' was added");
        view.forward(req, resp);
    }
}
