package dao.provider;

import java.math.BigDecimal;

public interface ProviderDao {
    boolean checkBalance(String user, BigDecimal amount);
}
