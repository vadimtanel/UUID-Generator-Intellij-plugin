import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import groovy.transform.ToString;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.UUID;

/*******************************************************************************
 *  Created by Vadim Tanel on 28/11/2019 10:14.
 *  Copyright © 2019 Vadim Tanel.
 *  All rights reserved.
 ******************************************************************************/

public class Generator  extends AnAction {
    public Generator() {
        super("Generate UUID to clipboard");
    }

    public void actionPerformed(AnActionEvent event) {
        Project project = event.getProject();
        String uuid = Generator.generateUUIDStr();
        saveStringToClipBoard(uuid);
        System.out.println("UUID:\n\r" + uuid);
//        Messages.showMessageDialog(project, "UUID:\n\r" + uuid, "UUID Generator", Messages.getInformationIcon());
    }

    private void saveStringToClipBoard(String uuid) {
        StringSelection stringSelection = new StringSelection(uuid);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    private static String generateUUIDStr() {
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        return randomUUIDString;
    }

}
