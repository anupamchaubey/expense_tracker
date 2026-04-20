package com.anupam.expense_tracker.controller;

import com.anupam.expense_tracker.model.Expense;
import com.anupam.expense_tracker.service.ExpenseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    // Add Expense
    @PostMapping("/{userId}")
    public Expense addExpense(@PathVariable Long userId,
                              @RequestBody Expense expense) {
        return expenseService.addExpense(userId, expense);
    }

    // Get All Expenses for User
    @GetMapping("/{userId}")
    public List<Expense> getExpenses(@PathVariable Long userId) {
        return expenseService.getUserExpenses(userId);
    }

    @GetMapping("/summary/{userId}")
    public Map<String, Double> getSummary(@PathVariable Long userId) {
        return expenseService.getSummary(userId);
    }
}