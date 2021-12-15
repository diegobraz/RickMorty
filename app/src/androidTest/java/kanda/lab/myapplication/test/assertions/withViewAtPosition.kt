package kanda.lab.myapplication.test.assertions

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.core.AllOf

fun withViewAtPosition(position: Int, itemMatcher: Matcher<View?>): Matcher<View?> {
    return object : BoundedMatcher<View?, RecyclerView>(RecyclerView::class.java) {
        override fun describeTo(description: Description?) {
            itemMatcher.describeTo(description)
        }

        override fun matchesSafely(recyclerView: RecyclerView): Boolean {
            val viewHolder = recyclerView.findViewHolderForAdapterPosition(position)
            return viewHolder != null && itemMatcher.matches(viewHolder.itemView)
        }
    }
}

fun listMatches(position: Int, viewId: Int, matcher: Matcher<View>) = ViewAssertions.matches(
    withViewAtPosition(
        position, ViewMatchers.hasDescendant(AllOf.allOf(ViewMatchers.withId(viewId), matcher))
    )
)
