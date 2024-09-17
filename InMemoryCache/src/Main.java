import dao.CacheDao;
import service.CacheService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        CacheDao cacheDao = CacheDao.getInstance();
        CacheService cacheService = new CacheService(cacheDao);

        cacheService.createCache(2, "LRU");

        cacheService.put("Hi", "This is simran");
        cacheService.put("Hey", "This is simran gupta");

        cacheService.getObject("Hi");

        cacheService.remove("Hi");

        cacheService.put("num", 123);

        cacheService.clearCache();

        cacheService.getObject("Hey");

    }
}