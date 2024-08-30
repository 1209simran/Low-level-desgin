package service;

public class AdminService {

    private final TableService tableService;

    public AdminService(TableService tableService) {
        this.tableService = tableService;
    }
    
    public void addTable() {
        tableService.addTable();
    }

}
