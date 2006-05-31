/*
 * This file contains the definitions and function declarations to
 * handle network related stuff.
 *
 * Jakub S�awi�ski 2006-05-30
 * jeremian@poczta.fm
 */

#ifndef _JS_NETWORK_H
#define _JS_NETWORK_H

#include <I2util/util.h>

#define NDT_BACKLOG 5

#define OPT_IPV6_ONLY 1
#define OPT_IPV4_ONLY 2

I2Addr CreateListenSocket(I2Addr addr, char* serv, int options);
int CreateConnectSocket(int* sockfd, I2Addr local_addr, I2Addr server_addr, int options);

#endif
