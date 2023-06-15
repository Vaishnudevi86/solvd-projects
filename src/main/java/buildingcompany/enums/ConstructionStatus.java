package buildingcompany.enums;
    public enum ConstructionStatus {
        PLANNED("Planned"),
        IN_PROGRESS("In Progress"),
        COMPLETED("Completed"),
        CANCELLED("Cancelled");
        private String status;
        ConstructionStatus(String status) {
            this.status = status;
        }
        public String getStatus() {
            return status;
        }
    }
