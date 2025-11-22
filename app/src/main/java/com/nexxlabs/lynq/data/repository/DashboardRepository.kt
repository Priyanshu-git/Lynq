package com.nexxlabs.lynq.data.repository

import com.nexxlabs.lynq.model.domain.ListModel
import java.time.Instant
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class DashboardRepository @Inject constructor() {
    // temporary sample data
    fun getSampleLists(): List<ListModel> {
        val now = Instant.now().toString()
        return listOf(
            ListModel(
                "list_weekly_groceries",
                "Weekly Groceries",
                "Shopping for this week",
                "grocery",
                "user_a",
                "group_1",
                now,
                now,
                pendingCount = 3
            ),
            ListModel(
                "list_dinner_party",
                "Dinner Party Shopping",
                "Ingredients + drinks",
                "grocery",
                "user_b",
                "group_2",
                now,
                now,
                pendingCount = 6
            ),
            ListModel(
                "list_home_reno",
                "Home Renovation Tasks",
                "Tiles, paint, electrician",
                "general",
                "user_c",
                null,
                now,
                now,
                pendingCount = 4
            ),
            ListModel(
                "list_organic",
                "Organic Produce",
                "Veggies & fruits",
                "grocery",
                "user_d",
                "group_3",
                now,
                now,
                pendingCount = 1
            ),
            ListModel(
                "list_project_check",
                "Project Checklist",
                "Milestones and tasks",
                "general",
                "user_e",
                "group_4",
                now,
                now,
                pendingCount = 7
            )
        )
    }
}