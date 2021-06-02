/*
 * Copyright (c) 2008-2021
 * LANIT
 * All rights reserved.
 *
 * This product and related documentation are protected by copyright and
 * distributed under licenses restricting its use, copying, distribution, and
 * decompilation. No part of this product or related documentation may be
 * reproduced in any form by any means without prior written authorization of
 * LANIT and its licensors, if any.
 *
 * BorAdapter$
 */
package ru.lanit.bpm.demo.adapter.telegram;

/**
 * todo Document type BotAdapter
 */
public interface TelegramAdapter {
    void sendMessage(String telegramId, String message);

}
