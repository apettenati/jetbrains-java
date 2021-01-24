interface Spaceship {

    /**
     * Indicates if the launch was successful or if the rocket crashed
     *
     * @return true if launch was successful
     */
    public boolean launch();
        // Indicates if the launch was successful or if the rocket crashed

    public boolean land();
        // Confirms if the landing was successful

    public boolean canCarry(Item item);
        // Confirms if item is within the weight limit

    public int carry(Item item);
        // Updates the current weight of the rocket

}
