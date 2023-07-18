package net.codingwithcalvin.openbinfolder.actions

import com.intellij.openapi.actionSystem.ActionUpdateThread
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages
import com.jetbrains.rider.projectView.solution
import com.jetbrains.rider.projectView.workspace.getProjectModelEntity
import com.jetbrains.rider.projectView.workspace.isProject

class OpenBinFolderAction :  AnAction() {
    override fun getActionUpdateThread(): ActionUpdateThread {
        return ActionUpdateThread.BGT
    }

    override fun update(e: AnActionEvent) {
        e.presentation.isVisible = e.dataContext.getProjectModelEntity()?.isProject() ?: false
    }

    override fun actionPerformed(event: AnActionEvent) {
        val project: Project = event.project ?: return
        val activeConfiguration = project.solution.solutionProperties.activeConfigurationPlatform.value?.configuration ?: return

        Messages.showMessageDialog(activeConfiguration, "", Messages.getQuestionIcon())
    }
}