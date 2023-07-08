package net.codingwithcalvin.openbinfolder.actions

import com.intellij.execution.RunManager
import com.intellij.openapi.actionSystem.ActionUpdateThread
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages

class OpenBinFolderAction :  AnAction() {
    override fun getActionUpdateThread(): ActionUpdateThread {
        return ActionUpdateThread.BGT
    }

    override fun update(e: AnActionEvent) {
        e.presentation.isEnabledAndVisible = false

        val project: Project = e.project ?: return

        if (project.isDefault) {
            return
        }

        e.presentation.isVisible = true
        e.presentation.isEnabledAndVisible = true
    }

    override fun actionPerformed(event: AnActionEvent) {
        val project: Project = event.project ?: return
        val runManager: RunManager = RunManager.getInstance(project)
        val firstConfiguration = runManager.allConfigurationsList.first()

        Messages.showMessageDialog("Who knows", "", Messages.getQuestionIcon())
    }
}