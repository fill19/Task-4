package Polytech.Labaratory4.model;

import Polytech.Labaratory4.enums.Priority;
import Polytech.Labaratory4.enums.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Ticket {

    private String ticketId;
    private String name;
    private String description;
    private List<String> assigneeList; // assignee ids
    private String reporter; // reporter id
    private Status status;
    private Priority priority;
    private long estimatedTime;
    private static long totalEstimatedTime;
    private long spentTime;
    private LocalDate creationDate;
    private LocalDateTime startDate;

    public Ticket(String ticketId,
                  String name,
                  String description,
                  List<String> assigneeList,
                  String reporter,
                  Status status,
                  Priority priority,
                  long estimatedTime,
                  long spentTime,
                  LocalDate creationDate
    ) {
        this.ticketId = ticketId;
        this.name = name;
        this.description = description;
        this.assigneeList = assigneeList;
        this.reporter = reporter;
        this.status = status;
        this.priority = priority;
        this.estimatedTime = estimatedTime; // time in seconds
        this.spentTime = spentTime; // time in seconds
        this.creationDate = creationDate;
        totalEstimatedTime += this.estimatedTime;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getAssigneeList() {
        return assigneeList;
    }

    public void setAssigneeList(List<String> assigneeList) {
        this.assigneeList = assigneeList;
    }

    public String getReporter() {
        return reporter;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public long getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(long estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public long getSpentTime() {
        return spentTime;
    }

    public void setSpentTime(long spentTime) {
        this.spentTime = spentTime;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public static long getTotalEstimatedTime() {
        return totalEstimatedTime;
    }
}
