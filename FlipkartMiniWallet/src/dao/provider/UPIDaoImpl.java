package dao.provider;

import java.math.BigDecimal;

public class UPIDaoImpl implements ProviderDao{
    @Override
    public boolean checkBalance(String user, BigDecimal amount) {
        return true;
    }
}
