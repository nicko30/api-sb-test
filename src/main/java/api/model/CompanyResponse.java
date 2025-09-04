package api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyResponse {
    private String status;
    private Integer code;
    private Integer total;
    private List<Company> data;

    // Getters
    public String getStatus() { return status; }
    public Integer getCode() { return code; }
    public Integer getTotal() { return total; }
    public List<Company> getData() { return data; }

    // Setters
    public void setStatus(String status) { this.status = status; }
    public void setCode(Integer code) { this.code = code; }
    public void setTotal(Integer total) { this.total = total; }
    public void setData(List<Company> data) { this.data = data; }
}
