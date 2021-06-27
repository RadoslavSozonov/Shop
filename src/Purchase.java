public class Purchase {
    private String description;

    /**
     * Constructor of the class
     * @param description - description of the purchase
     */
    public Purchase(String description) {
        this.description = description;
    }

    /**
     * Get the description of the purchase
     * @return - the description of the purchase
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set a new description of the purchase
     * @param description - description of the purchase
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
